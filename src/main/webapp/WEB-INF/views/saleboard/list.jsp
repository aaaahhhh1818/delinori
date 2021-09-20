<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--헤더 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<%@ include file="../includes/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">중고거래 게시판</h1>
        <a href="/saleboard/register" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">글쓰기</a>
    </div>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">팝니다.</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div class="dataTables_length" id="dataTable_length">
                            <label>Show
                                <select name="dataTable_length" aria-controls="dataTable"
                                        class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="10" ${pageMaker.size==10?"selected":""}>10</option>
                                    <option value="25" ${pageMaker.size==25?"selected":""}>25</option>
                                    <option value="50" ${pageMaker.size==50?"selected":""}>50</option>
                                    <option value="100" ${pageMaker.size==100?"selected":""}>100</option>
                                </select>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>SNO</th>
                                <th>TITLE</th>
                                <th>WRITER</th>
                                <th>REGDATE</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dtoList}" var="dto">
                                <tr>
                                    <td><c:out value="${dto.sno}"></c:out></td>
                                    <td><a href="javascript:moveRead(${dto.sno})"><c:out value="${dto.title}"></c:out></a>
                                    </td>
                                    <td><c:out value="${dto.writer}"></c:out></td>
                                    <td><c:out value="${dto.regDate}"></c:out></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 페이징 -->
                <div class="col-sm-12 col-md-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                        <ul class="pagination">

                            <c:if test="${pageMaker.prev}">
                                <li class="paginate_button page-item previous" id="dataTable_previous">
                                    <a href="javascript:movePage(${pageMaker.start -1})" class="page-link">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                                <li class="paginate_button page-item ${pageMaker.page==num?'active':''}">
                                    <a href="javascript:movePage(${num})" class="page-link">${num}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${pageMaker.next}">
                                <li class="paginate_button page-item next" id="dataTable_next">
                                    <a href="javascript:movePage(${pageMaker.end +1})" class="page-link">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>


                    <!-- 페이징 End -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Modal-->
<div class="modal fade" id="submitModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">작성 완료!</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">작성 완료 했습니다.</div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" data-dismiss="modal">확인</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal End -->

<form id="actionForm" action="/saleboard/list" method="get">
    <input type="hidden" name="page" value="${pageMaker.page}">
    <input type="hidden" name="size" value="${pageMaker.size}">

    <c:if test="${pageRequestDTO.type != null}">
        <input type="hidden" name="type" value="${pageRequestDTO.type}">
        <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
    </c:if>
</form>

<!--푸터 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<%@ include file="../includes/footer.jsp" %>

<script>

    const actionForm = document.querySelector("#actionForm")

    const result = '${result}'

    if (result && result !== '') {
        $('#submitModal').modal('show')
        window.history.replaceState(null, '', '/saleboard/list')
    }

    function moveRead(sno) {

        actionForm.setAttribute("action", "/saleboard/read")
        actionForm.innerHTML += `<input type='hidden' name='sno' value='\${sno}'>`
        actionForm.submit()

    }

    function movePage(pageNum) {

        actionForm.querySelector("input[name='page']").setAttribute("value", pageNum)

        actionForm.submit()

    }

</script>

</body>

</html>