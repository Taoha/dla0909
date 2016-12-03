package com.example.imac.giftsbpp.base;

/**
 * Created by imac on 16/11/23.
 */

public class URLValues {
    //hometab标题url
    public static final String HOME_TITLE = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    //获取首页精选url
    public static final String HOME_CHOICE = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    //获取六宫格url
    public static final String HOME_SIX = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";
    //获取轮播图的url
    public static final String HOME_BANNER="http://api.liwushuo.com/v2/banners";
    //获取榜单的标题url
    public static final String LIST_TITLE = "http://api.liwushuo.com/v2/ranks_v2/ranks";
    //获取分类攻略横向的url
    public static final String KIND_RECY = "http://api.liwushuo.com/v2/columns";
    //获取分类的Grid的url
    public static final String KIND_GRID = "http://api.liwushuo.com/v2/channel_groups/all";
    //获取分类单品的URL
    public static final String SKU_URL = "http://api.liwushuo.com/v2/item_categories/tree";


}