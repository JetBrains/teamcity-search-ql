<%@     taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
        taglib prefix="forms" tagdir="/WEB-INF/tags/forms"%>
<form action="<c:url value='/admin/admin.html'/>" method="get">
    <div class="actionBar">
        <span class="nowrap">
          <label class="firstLabel" for="keyword">Keyword: </label>
          <forms:textField name="keyword" value="${searchForm.getKeyword()}" size="40" style="width: 360px"/>
        </span>
          <forms:filterButton/>
          <div class="smallNote" style="margin-left: 6em; line-height: 1.5">Search projects, build configurations, templates, etc.</div>
          <div class="clearfix"></div>
    </div>
    <div>
        <c:choose>
            <c:when test="${searchForm.isNothingFound()}">
                Nothing found.
                <br />
            </c:when>
            <c:otherwise>

                <c:if test="${searchForm.hasProjects()}">
                    <h3>Projects:</h3>
                    <ol>
                        <c:forEach items="${searchForm.resultProjects}" var="project">
                            <li>
                                <a href="${project.first}">${project.second}</a>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>

                <c:if test="${searchForm.hasBuildConfs()}">
                    <h3>Build configurations:</h3>
                    <ol>
                        <c:forEach items="${searchForm.resultBuildConfigurations}" var="buildConf">
                            <li>
                                <a href="${buildConf.first}">${buildConf.second}</a>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>

                <c:if test="${searchForm.hasTemplates()}">
                    <h3>Build configuration templates:</h3>
                    <ol>
                        <c:forEach items="${searchForm.resultTemplates}" var="temp">
                            <li>
                                <a href="${temp.first}">${temp.second}</a>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>

                <c:if test="${searchForm.hasVcsRoots()}">
                    <h3>VCS roots:</h3>
                    <ol>
                        <c:forEach items="${searchForm.resultVcsRoots}" var="vcs">
                            <li>
                                <a href="${vcs.first}">${vcs.second}</a>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>
    <input type="hidden" name="item" value="search">
</form>