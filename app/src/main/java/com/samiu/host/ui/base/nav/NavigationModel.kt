package com.samiu.host.ui.base.nav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.samiu.host.R

/**
 * @author Samiu 2020/4/2
 */
object NavigationModel {

    private var navigationMenuItems = mutableListOf(
        NavigationModelItem.NavMenuItem(
            id = 0,
            icon = R.drawable.ic_twotone_inbox,
            titleRes = R.string.home,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = 1,
            icon = R.drawable.ic_twotone_stars,
            titleRes = R.string.square,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = 2,
            icon = R.drawable.ic_twotone_send,
            titleRes = R.string.wx_article,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = 3,
            icon = R.drawable.ic_twotone_delete,
            titleRes = R.string.system,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = 4,
            icon = R.drawable.ic_twotone_error,
            titleRes = R.string.navigation,
            checked = false
        ),
        NavigationModelItem.NavMenuItem(
            id = 5,
            icon = R.drawable.ic_twotone_drafts,
            titleRes = R.string.navigation_drafts,
            checked = false
        )
    )

    private val _navigationList: MutableLiveData<List<NavigationModelItem>> = MutableLiveData()
    val navigationList: LiveData<List<NavigationModelItem>>
        get() = _navigationList

    /**
     * 设置选中的item
     * @param id
     * @return 选中的item发生变化就返回true，否则false
     */
    fun setNavigationMenuItemChecked(id: Int): Boolean {
        var updated = false
        val newList = mutableListOf<NavigationModelItem>()
        navigationMenuItems.forEach { item: NavigationModelItem.NavMenuItem? ->
            item?.let {
                val shouldCheck = it.id == id
                if (it.checked != shouldCheck)
                    updated = true
                newList.add(it.copy(checked = shouldCheck))
            }
        }
        if (updated)
            _navigationList.value = newList
        return updated
    }
}