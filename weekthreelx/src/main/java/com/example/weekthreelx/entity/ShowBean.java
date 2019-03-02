package com.example.weekthreelx.entity;

import java.util.List;

public class ShowBean {


    private String message;//message : 查询成功
    private String status;//status : 0000
    private List<ResultBean> result;//集合

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

        public boolean isIschecked;
        private int commodityId;//commodityId : 5
        private String commodityName;//commodityName : 双头两用修容笔
        private int count;//count : 3
        private String pic;//pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
        private int price;//price : 39

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
