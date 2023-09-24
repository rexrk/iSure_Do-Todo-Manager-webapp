<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1 class="mb-3">Add Todo</h1>
    <div>
        <sf:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <sf:label path="description">Description</sf:label>
                <sf:input type="text" path="description" required="required" cssClass="text-bg-"/>
                <sf:errors path="description" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">
                <sf:label path="date">Target Date</sf:label>
                <sf:input type="text" path="date" required="required" cssClass="text-bg-"/>
                <sf:errors path="date" cssClass="text-warning"/>
            </fieldset>
            <sf:input type="hidden" path="id"/>
            <sf:input type="hidden" path="done"/>
            <input type="submit" class="btn btn-success"/>
        </sf:form>
    </div>
</div>
<%@include file="common/footer.jspf" %>