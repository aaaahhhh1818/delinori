<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--헤더 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<%@ include file="../includes/header.jsp" %>

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">SALEBOARD READ</h1>
                        </div>
                        <form id="form1"> <%--실제로 날라가는애--%>
                            <input type="hidden" name="page" value="${pageRequestDTO.page}">
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">

                            <c:if test="${pageRequestDTO.type != null}">
                            <input type="hidden" name="type" value="${pageRequestDTO.type}">
                            <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
                            </c:if>
                        <label for="title">Sno</label>
                        <div class="form-group">
                            <input type="text" name="sno" class="form-control form-control-user" id="sno"
                                   value="<c:out value="${saleBoardDTO.sno}"></c:out>"
                                   placeholder="sno" readonly>
                        </div>
                        <label for="title">Title</label>
                        <div class="form-group">
                            <input type="text" name="title" class="form-control form-control-user" id="title"
                                   value="<c:out value="${saleBoardDTO.title}"></c:out>"
                                   placeholder="title" readonly>
                        </div>
                        <label for="writer">Writer</label>
                        <div class="form-group">
                            <input type="text" name="writer" class="form-control form-control-user" id="writer"
                                   value="<c:out value="${saleBoardDTO.writer}"></c:out>"
                                   placeholder="writer" readonly>
                        </div>
                        <label for="content">Content</label>
                        <div class="form-group">
                                <textarea name="content" class="form-control form-control-user" id="content" disabled><c:out value="${saleBoardDTO.content}"></c:out></textarea>
                        </div>
                        <div>
                            <button type="button" class="btn btn-primary btn-user btn-block btnList">LIST</button>
                            <button type="button" class="btn btn-success btn-user btn-block btnMod">MODIFY</button>
                            <button type="button" class="btn btn-danger btn-user btn-block btnDel">DELETE</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<form id="actionForm" action="/saleboard/list" method="get">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">

    <c:if test="${pageRequestDTO.type != null}">
        <input type="hidden" name="type" value="${pageRequestDTO.type}">
        <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
    </c:if>
</form>

<!--푸터 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<%@ include file="../includes/footer.jsp" %>

<script>

    const form = document.querySelector("#form1")
    const actionForm = document.querySelector("#actionForm")

    document.querySelector(".btnList").addEventListener("click", () => {
        actionForm.submit()
    }, false)

    document.querySelector(".btnMod").addEventListener("click", () => {

        const sno = '${saleBoardDTO.sno}'

        actionForm.setAttribute("action", "/saleboard/modify")
        actionForm.innerHTML += `<input type='hidden' name='sno' value='\${sno}'>`
        actionForm.submit()
    }, false)

    document.querySelector(".btnDel").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        form.setAttribute("action","/saleboard/remove")
        form.setAttribute("method","post")
        form.submit()

    },false)

</script>

</body>

</html>