package com.dreamer.education.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * @param <T> 实体类
 * @since 2013-10-25 上午10:24:33
 * @author broken_xie
 */
public class Page<T extends Serializable> implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -2116007164173561040L;
    
    /** 每页显示的记录数 */
    private int pageSize = 10;
    
    /** 总页数 */
    private int totalPage;
    
    /** 当前页页码 */
    private int currentPage;
    
    /** 上一组索引的页码 */
    private int prePageIndex;
    
    /** 当前页的索引数组 */
    private int[] pageIndex;
    
    /** 下一组索引的页码 */
    private int nextPageIndex;
    
    /** 索引数组长度 */
    private int pageIndexLength = 10;
    
    /** 总记录数 */
    private int totalRow;
    
    /** 当前页在数据库中的起始行 */
    private int startRow;
    
    /** 上一页页码 */
    private int prePage;
    
    /** 下一页页码 */
    private int nextPage;
    
    /** 当前页显示的记录集合 */
    protected List<T> resultRows;
    
    /**
     * 无参构造函数
     * @author broken_xie
     */
    public Page() {}
    
    /**
     * 构造函数
     * @param currentPage 当前页页码
     * @author broken_xie
     */
    public Page(int currentPage) {
        this.currentPage = currentPage;
    }
    
    /**
     * 参数初始化
     * @author broken_xie
     */
    private void init() {
        // 初始化总页数
        totalPage = totalRow / pageSize + (0 == totalRow % pageSize ? 0 : 1);
        totalPage = 0 == totalPage ? 1 : totalPage;
        // 初始化当前页码
        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        // 初始化当前页在数据库中的起始行
        startRow = (currentPage - 1) * pageSize;
        // 初始化上一页页码
        prePage = (1 == currentPage ? 1 : currentPage - 1);
        // 初始化下一页页码
        nextPage = (currentPage == totalPage ? totalPage : currentPage + 1);
    }
    
    /**
     * 判断是否存在上一页【true：存在；false：不存在】
     * @return
     * @author broken_xie
     */
    public boolean isHasPrePage() {
        return currentPage != 1;
    }
    
    /**
     * 判断是否存在下一页【true：存在；false：不存在】
     * @return
     * @author broken_xie
     */
    public boolean isHasNextPage() {
        return currentPage != totalPage;
    }
    
    /**
     * 判断当前索引组前是否含有索引 即 若当前索引组为第一组索引，则返回false
     * @return
     * @author broken_xie
     */
    public boolean isHasPreviousIndex() {
        return currentPage > pageIndexLength / 2 + 1;
    }
    
    /**
     * 判断当前索引组后是否含有索引 即 若当前索引组为最后一组索引，则返回false
     * @return
     * @author broken_xie
     */
    public boolean isHasNextIndex() {
        return currentPage < totalPage - (pageIndexLength - pageIndexLength / 2 - 1);
    }
    
    /**
     * 获取 每页显示的记录数
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * 设置 每页显示的记录数【调用init()方法重新初始化】
     * @param pageSize 每页显示的记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        init();
    }
    
    /**
     * 获取 总页数
     * @return totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }
    
    /**
     * 设置 总页数
     * @param totalPage 总页数
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    /**
     * 获取 当前页页码
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * 设置 当前页页码【调用init()方法重新初始化】
     * @param currentPage 当前页页码
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        init();
    }
    
    /**
     * 获取 上一组索引的页码
     * @return prePageIndex
     */
    public int getPrePageIndex() {
        prePageIndex = getPageIndex()[getPageIndex().length / 2] - pageIndexLength;
        if (prePageIndex < 1) {
            prePageIndex = 1;
        }
        return prePageIndex;
    }
    
    /**
     * 设置 上一组索引的页码
     * @param prePageIndex 上一组索引的页码
     */
    public void setPrePageIndex(int prePageIndex) {
        this.prePageIndex = prePageIndex;
    }
    
    /**
     * 获取 当前页的索引数组
     * @return pageIndex
     */
    public int[] getPageIndex() {
        if (totalPage <= pageIndexLength) { // 总页数小于等于索引数组长度时，设置索引数组长度为总页数
            pageIndex = new int[totalPage];
            for (int i = 0; i < totalPage; i++) {
                pageIndex[i] = i + 1;
            }
        } else {
            pageIndex = new int[pageIndexLength];
            int half = pageIndexLength / 2;
            if (currentPage <= half) { // 当前页页码小于等于索引数组长度 一般时，索引数组从第一页开始
                for (int i = 0; i < pageIndex.length; i++) {
                    pageIndex[i] = i + 1;
                }
            } else if (currentPage >= totalPage - half + 1) { // 当前页页码接近总页数并且间隔小于索引组一半长度时 则索引组从最大页开始反向往前索引
                for (int i = pageIndexLength - 1; i >= 0; i--) {
                    pageIndex[i] = totalPage + i + 1 - pageIndexLength;
                }
            } else {
                for (int i = 0; i < pageIndex.length; i++) {
                    pageIndex[i] = currentPage - half + i;
                }
            }
        }
        return pageIndex;
    }
    
    /**
     * 设置 当前页的索引数组
     * @param pageIndex 当前页的索引数组
     */
    public void setPageIndex(int[] pageIndex) {
        this.pageIndex = pageIndex;
    }
    
    /**
     * 获取 下一组索引的页码
     * @return nextPageIndex
     */
    public int getNextPageIndex() {
        nextPageIndex = getPageIndex()[getPageIndex().length / 2] + pageIndexLength;
        if (nextPageIndex > totalPage) {
            nextPageIndex = totalPage;
        }
        return nextPageIndex;
    }
    
    /**
     * 设置 下一组索引的页码
     * @param nextPageIndex 下一组索引的页码
     */
    public void setNextPageIndex(int nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }
    
    /**
     * 获取 索引数组长度
     * @return pageIndexLength
     */
    public int getPageIndexLength() {
        return pageIndexLength;
    }
    
    /**
     * 设置 索引数组长度
     * @param pageIndexLength 索引数组长度
     */
    public void setPageIndexLength(int pageIndexLength) {
        this.pageIndexLength = pageIndexLength;
    }
    
    /**
     * 获取 总记录数
     * @return totalRow
     */
    public int getTotalRow() {
        return totalRow;
    }
    
    /**
     * 设置 总记录数【调用init()方法重新初始化】
     * @param totalRow 总记录数
     */
    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
        init();
    }
    
    /**
     * 获取 当前页在数据库中的起始行
     * @return startRow
     */
    public int getStartRow() {
        return startRow;
    }
    
    /**
     * 设置 当前页在数据库中的起始行
     * @param startRow 当前页在数据库中的起始行
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    
    /**
     * 获取 上一页页码
     * @return prePage
     */
    public int getPrePage() {
        return prePage;
    }
    
    /**
     * 设置 上一页页码
     * @param prePage 上一页页码
     */
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
    
    /**
     * 获取 下一页页码
     * @return nextPage
     */
    public int getNextPage() {
        return nextPage;
    }
    
    /**
     * 设置 下一页页码
     * @param nextPage 下一页页码
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    
    /**
     * 获取 当前页显示的记录集合
     * @return resultRows
     */
    public List<T> getResultRows() {
        return resultRows;
    }
    
    /**
     * 设置 当前页显示的记录集合
     * @param resultRows 当前页显示的记录集合
     */
    public void setResultRows(List<T> resultRows) {
        this.resultRows = resultRows;
    }
    
}
