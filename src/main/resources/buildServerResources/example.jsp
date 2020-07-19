<%@     taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
        taglib prefix="forms" tagdir="/WEB-INF/tags/forms"%>
<form action="<c:url value='/admin/admin.html'/>" method="get">
    <div class="actionBar">
        <span class="nowrap">
          <label class="firstLabel" for="keyword">Keyword: </label>
          <forms:textField name="keyword" value="${adminOverviewForm.keyword}" size="40" style="width: 360px"/>
        </span>
          <forms:filterButton/>
          <div class="smallNote" style="margin-left: 6em; line-height: 1.5">Filter projects and build configurations by name, ID or description</div>
          <div class="clearfix"></div>
    </div>
    <div>
        ${searchResult}
    </div>
    <input type="hidden" name="item" value="search">
</form>