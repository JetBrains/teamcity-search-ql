<%@     taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
        taglib prefix="forms" tagdir="/WEB-INF/tags/forms"%><%@
        taglib prefix="util" uri="/WEB-INF/functions/util" %>

<form action="<c:url value='/admin/admin.html'/>" method="get">
    <div class="actionBar">
        <span class="nowrap">
            <label class="firstLabel" for="query">Query: </label>
            <c:url var="autocompletionUrl" value="/adminQueryAutocompletion.html"/>
            <forms:autocompletionTextField name="query" value="${searchForm.query}"
                                           style="width: 1000px; height: 30px; font-size: 15px"
                                           maxlength="256"
                                           size="256"
                                           autocompletionSource="BS.QueryLanguage.createCompleteQueryFunction('${autocompletionUrl}')"
                                           autocompletionShowOnFocus="true"
                                           autocompletionShowEmpty="false"
                                           defaultText="find "
            />
        </span>
          <forms:filterButton/>
          <div class="smallNote" style="margin-left: 6em; line-height: 1.5">Search projects, build configurations, templates, vcsRoots, etc.</div>
          <div class="clearfix"></div>
    </div>
    <div>
        <c:choose>
        <c:when test="${searchForm.isWrongQuery()}">
            <h3 style="color:red">${searchForm.getWrongQueryMessage()}</h3>
        </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${searchForm.isNothingFound()}">
                        Nothing found.
                        <br />
                    </c:when>
                    <c:otherwise>
                        <c:if test="${searchForm.hasProjects()}">
                            <h3>Projects:</h3>
                            <ul style="list-style-type:none">
                                <c:forEach items="${searchForm.resultProjects}" var="project">
                                    <li>
                                        <a href="${project.first}">${project.second}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>

                        <c:if test="${searchForm.hasBuildConfs()}">
                            <h3>Build configurations:</h3>
                            <ul style="list-style-type:none">
                                <c:forEach items="${searchForm.resultBuildConfigurations}" var="buildConf">
                                    <li>
                                        <a href="${buildConf.first}">${buildConf.second}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>

                        <c:if test="${searchForm.hasTemplates()}">
                            <h3>Build configuration templates:</h3>
                            <ul style="list-style-type:none">
                                <c:forEach items="${searchForm.resultTemplates}" var="temp">
                                    <li>
                                        <a href="${temp.first}">${temp.second}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>

                        <c:if test="${searchForm.hasVcsRoots()}">
                            <h3>VCS roots:</h3>
                            <ul style="list-style-type:none">
                                <c:forEach items="${searchForm.resultVcsRoots}" var="vcs">
                                    <li>
                                        <a href="${vcs.first}">${vcs.second}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </div>
    <input type="hidden" name="item" value="search">
</form>

<script language="JavaScript">
    BS.QueryLanguage = {
        createCompleteQueryFunction: function (baseUrl) {
            return function (request, response) {
                var term = request.term;
                var url = baseUrl + '?term=' + encodeURIComponent(term);
                $j.getJSON(url, function(data) {
                    response(data);
                });
            }
        },

        createShowVariantsFunction: function (form) {
            return function () {

            }
        }
    };
</script>