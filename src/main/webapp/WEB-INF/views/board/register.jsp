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
                            <h1 class="h4 text-gray-900 mb-4">SALEBOARD REGISTER</h1>
                        </div>
                        <form id="form1" action="/board/register" method="post">
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input type="text" name="title" class="form-control form-control-user" id="title"
                                       placeholder="title">
                            </div>
                            <label for="writer">Writer</label>
                            <div class="form-group">
                                <input type="text" name="writer" class="form-control form-control-user" id="writer"
                                       placeholder="writer">
                            </div>
                            <label for="content">Content</label>
                            <div class="form-group">
                                <textarea name="content" class="form-control form-control-user" id="content"
                                          placeholder="content"></textarea>
                            </div>
                            <div>
                                <button type="submit" id="submitBtn" class="btn btn-primary btn-user btn-block">SUBMIT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!--푸터 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<%@ include file="../includes/footer.jsp" %>

</body>

</html>