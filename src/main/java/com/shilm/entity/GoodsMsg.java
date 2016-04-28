package com.shilm.entity;

/**
 * <p>Description: </p>
 *	商品实体类
 * @author 宿舍楼顶
 * @date 2016年4月27日
 * 联系方式：shilm@carnation.com.cn
 */
public class GoodsMsg {
	/**
	 * 产品类型
	 */
	public String type;
	/**
	 * 产品全名
	 */
	public String name;
	/**
	 * 产品id
	 */
	public String id;
	/**
	 * 产品地址
	 */
	public String url;
	/**
	 * 评论数
	 */
	public String commentCount;
	/**
	 * 好评数
	 */
	
	public String goodCount;
	/**
	 * 好评率
	 */
	public String goodRate;
	/**
	 * 好评百分比
	 */
	public String goodRateShow;
	/**
	 * 中评数
	 */
	public String generalCount;
	/**
	 * 中评率
	 */
	public String generalRate;
	/**
	 * 中评百分比
	 */
	public String generalRateShow;
	
	/**
	 * 差评数
	 */
	public String poorCount;
	/**
	 * 差评率
	 */
	public String poorRate;
	/**
	 * 差评百分比
	 */
	public String poorRateShow;
	/**
	 * 价格
	 */
	public String price ;
	
	/**
	 * 价格m
	 */
	public String mprice ;
	
	
	/**
	 * 有图片评论
	 */
	
	public String picCount;
	
	/**
	 * 提示信息
	 */
	public String prompt;
	
	/**
	 * 页码
	 */
	public String page;
	
	/**
	 * 线程名称
	 */
	public String thName;
	
	/**
	 * 父类url
	 */
	public String parUrl;
	
	
	public String getParUrl() {
		return parUrl;
	}
	public void setParUrl(String parUrl) {
		this.parUrl = parUrl;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getName() {
		return name;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	public String getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(String goodCount) {
		this.goodCount = goodCount;
	}
	public String getGoodRate() {
		return goodRate;
	}
	public void setGoodRate(String goodRate) {
		this.goodRate = goodRate;
	}
	public String getGoodRateShow() {
		return goodRateShow;
	}
	public void setGoodRateShow(String goodRateShow) {
		this.goodRateShow = goodRateShow;
	}
	public String getGeneralCount() {
		return generalCount;
	}
	public void setGeneralCount(String generalCount) {
		this.generalCount = generalCount;
	}
	public String getGeneralRate() {
		return generalRate;
	}
	public void setGeneralRate(String generalRate) {
		this.generalRate = generalRate;
	}
	public String getGeneralRateShow() {
		return generalRateShow;
	}
	public void setGeneralRateShow(String generalRateShow) {
		this.generalRateShow = generalRateShow;
	}
	public String getPoorCount() {
		return poorCount;
	}
	public void setPoorCount(String poorCount) {
		this.poorCount = poorCount;
	}
	public String getPoorRate() {
		return poorRate;
	}
	public void setPoorRate(String poorRate) {
		this.poorRate = poorRate;
	}
	public String getPoorRateShow() {
		return poorRateShow;
	}
	public void setPoorRateShow(String poorRateShow) {
		this.poorRateShow = poorRateShow;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
	
	
	public String getPicCount() {
		return picCount;
	}
	public void setPicCount(String picCount) {
		this.picCount = picCount;
	}
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getThName() {
		return thName;
	}
	public void setThName(String thName) {
		this.thName = thName;
	}
	public String toString(){
		return this.type+"="+this.name+"="+this.id+"="+this.url+"="+this.commentCount+""
				+ "="+this.goodCount+"="+this.goodRate+"="+this.goodRateShow+"="+this.generalCount+"="+
				this.generalRate+"="+this.generalRateShow+"="+this.poorCount+"="+this.poorRate+"="+this.poorRateShow+""+this.picCount+""
						+ "="+this.price+"="+this.mprice+"="+this.prompt;
	}
	
}

