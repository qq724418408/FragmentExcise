package wjl.forms.com.fragmentexcise.bean;

import java.util.List;

/**
 * Created by bubbly on 2017/3/15.
 */

public class OrderBean {

    private String orderId; // 订单id
    private String userId; // 用户id
    private String storeId; // 店铺id
    private String orderNum; // 订单号（参考）：店铺id（后三位） + 用户id（后三位） + 用户手机号（后四位） + 流水号（0000-9999）
    private String status; // 订单状态：未支付、未配送、送餐中、已完成、已评价
    private List<FoodBean> foodBeanList; // 食品列表
    private String distributingFee; // 配送费
    private String actualPayment; // 实付金额
    private String orderTime; // 下单时间
    private String payTime; // 支付时间
    private String address; // 送餐地址

}
