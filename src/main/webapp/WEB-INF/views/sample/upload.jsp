<%--
  Created by IntelliJ IDEA.
  User: ahyun
  Date: 2021-09-25
  Time: 오전 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<input type="file" name="uploadFiles" multiple><button id="uploadBtn">UPLOAD</button>

<div class="uploadResult">

</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>

    const uploadResultDiv = document.querySelector(".uploadResult")

    document.querySelector("#uploadBtn").addEventListener("click", (e) => {

        const formData = new FormData()
        const fileInput = document.querySelector("Input[name='uploadFiles']")

        for(let i = 0; i < fileInput.files.length; i++) {
            formData.append("uploadFiles", fileInput[i])
        }

        console.dir(formData)

        const headerObj = { headers: {'Content-Type': 'multipart/form-data'}}

        axios.post("/upload", formData, headerObj).then((response) => {

            const arr = response.data
            console.log(arr)

            let str = ""

            for(let i = 0; i < arr.length; i++) {

                const {uuid, fileName, uploadPath, image, thumbnail, fileLink} = {...arr[i]}
            }

        })

    }, false)

</script>

</body>
</html>
