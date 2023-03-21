package com.atguigu.spring.dao;

public interface BookDao {
    /**
     * 更新图书价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新图书余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
