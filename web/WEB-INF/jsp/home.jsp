<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isELIgnored="false" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Admin</title>
    </head>
    <body>
        <h1>Jurnal Penerimaan Kas</h1>
        <p>
            <button class="btn btn-primary" onclick="window.location.href='kas-form.html'">Add Mahasiswa</button>
        </p>
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Tanggal</th>
                <th>Keterangan</th>
                <th>Pemasukan</th>
                <th>Pengeluaran</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listKas}" var="kas">
                <tr>
                    <td>${kas.id}</td>
                    <td>${kas.tanggal}</td>
                    <td>${kas.keterangan}</td>
                    <td>${kas.pemasukan}</td>
                    <td>${kas.pengeluaran}</td>
                    <td>
                        <a href="kas-form.html?action=edit&id=${kas.id}" >Edit</a>
<!--                        <button class="btn btn-primary" 
                            onclick="window.location.href='kas-form.html?action=edit&id=${kas.id}'">
                        Edit
                    </button>-->
                        <a href="kas-form.html?action=delete&id=${kas.id}" onclick="return confirm('Anda yakin akan menghapus data ini ?');">Delete</a>
<!--                    <button class="btn btn-danger" 
                            onclick="window.location.href='kas-form.html?action=delete&id=${kas.id}'">
                        Delete
                    </button>-->
                    </td>
                </tr>
             </c:forEach>
        </table>
    </body>
</html>