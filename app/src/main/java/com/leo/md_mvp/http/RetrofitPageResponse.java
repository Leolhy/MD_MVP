package com.leo.md_mvp.http;

import java.util.List;

/**
 * Author: Leoying
 * Date: 2019-04-18
 * Desc:
 */

public class RetrofitPageResponse<T> extends BaseResponse {

    /**
     * data : {"curPage":1,"datas":[],"offset":0,"over":false,"pageCount":9,"size":15,"total":131}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean<T> data;

    public DataBean<T> getData() {
        return data;
    }

    public void setData(DataBean<T> data) {
        this.data = data;
    }

    public static class DataBean<T> {
        /**
         * curPage : 1
         * datas : []
         * offset : 0
         * over : false
         * pageCount : 9
         * size : 15
         * total : 131
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<T> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<T> getDatas() {
            return datas;
        }

        public void setDatas(List<T> datas) {
            this.datas = datas;
        }
    }
}
