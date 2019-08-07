package com.example.skeleton.domain;

import com.example.skeleton.common.basicMethod.BasicDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yebing
 */
public class OnlineBugDTO extends BasicDTO implements Serializable {
    /** tapd的工作区id (OS项目管理） */
    private String workspaceId;

    /** 在tapd上的缺陷唯一标识 */
    private String bugTid;

    /** 状态 */
    private String status;

    /** 多状态查询*/
    private List<String> statusList;
    /** 创建人 */
    private String reporter;

    /** 当前处理人 */
    private String currentOwner;

    /** 创建时间 */
    private Date created;

    /** 标题 */
    private String title;

    /** 整个处理过程的状态变化流程记录 */
    private String flows;

    /** 严重程度 */
    private String severity;

    /** 修复人 */
    private String fixer;

    /** 测试人员 */
    private String te;

    /** 开发人员 */
    private String de;

    /** 参与人员 */
    private String participator;

    /** 缺陷根源 */
    private String source;

    /** 所属站点 */
    private String site;

    /** 解决方法 */
    private String resolution;

    /** 问题类型 */
    private String bugType;

    /** 接受处理时间 */
    private Date inProgressTime;

    /** 关闭时间 */
    private Date closed;

    /** bug的查看链接 */
    private String url;

    /** bug最后刷新时间 */
    private Date updateTime;

    /** 拒绝原因 */
    private String rejectReason;

    /** 创建人所在部门 */
    private String creatorDept;

    /** 频率 */
    private String frequency;

    /** 浏览器 */
    private String browser;

    /** 问题提出人 */
    private String firstFinder;

    /** 解决方案 */
    private String solution;

    /** 原因分析 */
    private String analytics;

    /** 解决时间 */
    private Date solveTime;

    /** 问题提出时间 */
    private Date findTime;

    /** 模块 */
    private String module;

    /** 缺陷类型 */
    private String cate;

    /** 复制到哪个项目里 */
    private String cpToSpaceId;

    /** 复制到的项目名称 */
    private String cpToSpaceName;

    /** 复制后的项目里的bugId */
    private String cpToBugId;

    /** 复制的bug查看Url地址 */
    private String cpToBugUrl;

    /** 转成需求的id */
    private String toStoryId;

    /** 转成需求的需求池id */
    private String toStorySpaceId;

    /** 转需求的url地址 */
    private String toStoryUrl;

    /** 软删除标记 */
    private Integer deleted;

    /** 故障等级 */
    private String errorLevel;

    private static final long serialVersionUID = 1L;

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId == null ? null : workspaceId.trim();
    }

    public String getBugTid() {
        return bugTid;
    }

    public void setBugTid(String bugTid) {
        this.bugTid = bugTid == null ? null : bugTid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter == null ? null : reporter.trim();
    }

    public String getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(String currentOwner) {
        this.currentOwner = currentOwner == null ? null : currentOwner.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFlows() {
        return flows;
    }

    public void setFlows(String flows) {
        this.flows = flows == null ? null : flows.trim();
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity == null ? null : severity.trim();
    }

    public String getFixer() {
        return fixer;
    }

    public void setFixer(String fixer) {
        this.fixer = fixer == null ? null : fixer.trim();
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te == null ? null : te.trim();
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de == null ? null : de.trim();
    }

    public String getParticipator() {
        return participator;
    }

    public void setParticipator(String participator) {
        this.participator = participator == null ? null : participator.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType == null ? null : bugType.trim();
    }

    public Date getInProgressTime() {
        return inProgressTime;
    }

    public void setInProgressTime(Date inProgressTime) {
        this.inProgressTime = inProgressTime;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public String getCreatorDept() {
        return creatorDept;
    }

    public void setCreatorDept(String creatorDept) {
        this.creatorDept = creatorDept == null ? null : creatorDept.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    public String getFirstFinder() {
        return firstFinder;
    }

    public void setFirstFinder(String firstFinder) {
        this.firstFinder = firstFinder == null ? null : firstFinder.trim();
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public String getAnalytics() {
        return analytics;
    }

    public void setAnalytics(String analytics) {
        this.analytics = analytics == null ? null : analytics.trim();
    }

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    public Date getFindTime() {
        return findTime;
    }

    public void setFindTime(Date findTime) {
        this.findTime = findTime;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate == null ? null : cate.trim();
    }

    public String getCpToSpaceId() {
        return cpToSpaceId;
    }

    public void setCpToSpaceId(String cpToSpaceId) {
        this.cpToSpaceId = cpToSpaceId == null ? null : cpToSpaceId.trim();
    }

    public String getCpToSpaceName() {
        return cpToSpaceName;
    }

    public void setCpToSpaceName(String cpToSpaceName) {
        this.cpToSpaceName = cpToSpaceName == null ? null : cpToSpaceName.trim();
    }

    public String getCpToBugId() {
        return cpToBugId;
    }

    public void setCpToBugId(String cpToBugId) {
        this.cpToBugId = cpToBugId == null ? null : cpToBugId.trim();
    }

    public String getCpToBugUrl() {
        return cpToBugUrl;
    }

    public void setCpToBugUrl(String cpToBugUrl) {
        this.cpToBugUrl = cpToBugUrl == null ? null : cpToBugUrl.trim();
    }

    public String getToStoryId() {
        return toStoryId;
    }

    public void setToStoryId(String toStoryId) {
        this.toStoryId = toStoryId == null ? null : toStoryId.trim();
    }

    public String getToStorySpaceId() {
        return toStorySpaceId;
    }

    public void setToStorySpaceId(String toStorySpaceId) {
        this.toStorySpaceId = toStorySpaceId == null ? null : toStorySpaceId.trim();
    }

    public String getToStoryUrl() {
        return toStoryUrl;
    }

    public void setToStoryUrl(String toStoryUrl) {
        this.toStoryUrl = toStoryUrl == null ? null : toStoryUrl.trim();
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel == null ? null : errorLevel.trim();
    }
}