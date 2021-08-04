<%@     taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
        taglib prefix="forms" tagdir="/WEB-INF/tags/forms"%><%@
        taglib prefix="util" uri="/WEB-INF/functions/util" %>

<form action="<c:url value='/admin/admin.html'/>" method="get">
    <details>
        <summary>Short documentation</summary>
        <p>This plugin implements a search for objects in TeamCity project model.
            The functionality is only available for system administrator and project admins via the <code>Search</code> tab in the administration menu.
            Currently it supports searching 4 types of entities: projects, build configurations, build configuration templates and VCS roots.</p>
        <h3 id="query-structure">Query structure</h3>
        <p><code>find &lt;entity type(s)&gt; [in &lt;project ID&gt;] with &lt;condition&gt;</code></p>
        <h3 id="examples-of-queries">Examples of queries</h3>
        <ul>
            <li><p><code>find vcsRoot with type jetbrains.git</code> </p>
                <blockquote>
                    <p>find VCS roots with type <code>jetbrains.git</code>;</p>
                </blockquote>
            </li>
            <li><p><code>find configuration, template in Project1 with trigger type vcsTrigger</code></p>
                <blockquote>
                    <p>find build configurations and templates that lie in the subtree of a project with an id Project1 and has at least one trigger with the type vcsTrigger;</p>
                </blockquote>
            </li>
            <li><p><code>find project with configuration (feature type pullRequests or vcs param branchSpec = *pull*)</code></p>
                <blockquote>
                    <p>find projects that contain build configurations with either Pull Requests build feature configured</p>
                    <pre><code><span class="hljs-keyword">or</span> <span class="hljs-keyword">a</span> VCS root <span class="hljs-keyword">with</span> <span class="hljs-keyword">a</span> branch specification matching certain pattern attached.
                    </code></pre></blockquote>
            </li>
            <li><p><code>find project with configuration trigger[all] type (vcsTrigger or schedulingTrigger)</code></p>
                <blockquote>
                    <p>find projects that contain build configurations which have at least one trigger and all triggers are of vcsTrigger or schedulingTrigger type.</p>
                </blockquote>
            </li>
        </ul>
        <h3 id="autocompletion">Autocompletion</h3>
        <p>Autocompletion for most text values is available only for the system administrator.
            But you can use context autocompletion. Type ? in the place of the string value.
            Only variants from the projects where you have `edit` permission or `view settings` permission will be shown
            and all previously typed conditions will be taken in the account.</p>
        <h3 id="more-information">More information</h3>
        <p>Source code: <a href="https://github.com/JetBrains/teamcity-search-ql">https://github.com/JetBrains/teamcity-search-ql</a></p>
        <p>Download link: <a href="https://plugins.jetbrains.com/plugin/15051-searchql">https://plugins.jetbrains.com/plugin/15051-searchql</a></p>
        <p>Please refer to <a href="https://github.com/JetBrains/teamcity-search-ql/blob/master/FOR_USERS.md">FOR_USERS.md</a> for a draft
            of the user documentation and to <a href="https://github.com/JetBrains/teamcity-search-ql/blob/master/FOR_DEVS.md">FOR_DEVS.md</a>
            if you are thinking of contributing to the plugin.</p>

    </details>
    <div class="actionBar">
        <span class="nowrap">
            <label class="firstLabel" for="query">Query: </label>
            <c:url var="autocompletionUrl" value="${searchForm.getPluginDescriptor().getPluginResourcesPath(\"adminQueryAutocompletion.html\")}"/>
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
        <div class="smallNote" style="margin-left: 6em; line-height: 1.5">Search projects, build configurations, templates, vcsRoots. You can find full docs <a href="https://github.com/JetBrains/teamcity-search-ql/blob/master/FOR_USERS.md">here</a> </div>
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
                    <b>Displayed ${searchForm.resultsDisplayed} out of ${searchForm.resultsTotal}</b>
                    <c:if test="${searchForm.hasProjects()}">
                        <h3>Projects:</h3>
                        <ul style="list-style-type:none">
                            <c:forEach items="${searchForm.resultProjects}" var="project">
                                <li>
                                    <a href="${project.objUrl}">${project.showObj}</a>
                                    <c:if test="${project.parentProjectUrl != null}">
                                        in
                                        <a href="${project.parentProjectUrl}">${project.showParent}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <c:if test="${searchForm.hasBuildConfs()}">
                        <h3>Build configurations:</h3>
                        <ul style="list-style-type:none">
                            <c:forEach items="${searchForm.resultBuildConfigurations}" var="buildConf">
                                <li>
                                    <a href="${buildConf.objUrl}">${buildConf.showObj}</a>
                                    <c:if test="${buildConf.parentProjectUrl != null}">
                                        in
                                        <a href="${buildConf.parentProjectUrl}">${buildConf.showParent}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <c:if test="${searchForm.hasTemplates()}">
                        <h3>Build configuration templates:</h3>
                        <ul style="list-style-type:none">
                            <c:forEach items="${searchForm.resultTemplates}" var="temp">
                                <li>
                                    <a href="${temp.objUrl}">${temp.showObj}</a>
                                    <c:if test="${temp.parentProjectUrl != null}">
                                        in
                                        <a href="${temp.parentProjectUrl}">${temp.showParent}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <c:if test="${searchForm.hasVcsRoots()}">
                        <h3>VCS roots:</h3>
                        <ul style="list-style-type:none">
                            <c:forEach items="${searchForm.resultVcsRoots}" var="vcs">
                                <li>
                                    <a href="${vcs.objUrl}">${vcs.showObj}</a>
                                    <c:if test="${vcs.parentProjectUrl != null}">
                                        in
                                        <a href="${vcs.parentProjectUrl}">${vcs.showParent}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <c:if test="${searchForm.hasMetaRunners()}">
                        <h3>Meta-Runners:</h3>
                        <ul style="list-style-type:none">
                            <c:forEach items="${searchForm.resultMetaRunners}" var="metaRunner">
                                <li>
                                    <a href="${metaRunner.objUrl}">${metaRunner.showObj}</a>
                                    <c:if test="${metaRunner.parentProjectUrl != null}">
                                        in
                                        <a href="${metaRunner.parentProjectUrl}">${metaRunner.showParent}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <c:if test="${searchForm.resultsDisplayed != searchForm.resultsTotal}">
                <a class="btn btn_mini btn_icon"
                   href="${requestScope['javax.servlet.forward.request_uri']}?query=${searchForm.urlEncodeStr(pageContext.request.getParameter("query"))}&submitFilter=Filter&item=search-ql&limit=${searchForm.resultsDisplayed * 2}"
                   title="Show more">Show more <span>&#9662;</span></a>
            </c:if>
        </c:otherwise>
        </c:choose>
    </div>
    <input type="hidden" name="item" value="search-ql">
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