
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Mahasiswa ${message}</h1><hr/>
<form action="kas-form.html" modelAttribute="kas" method="POST">
  <table>
    <tr>
      <td><label for="tanggal">Tanggal</label></td>
      <td>:</td>
      <td> <input type="text" class="form-control" name="tanggal" placeholder="tanggal" autocomplete="off" value="${kas.tanggal}" /></td>
    </tr>
    <tr>
      <td>
        <label for="Keterangan">Keterangan</label>
      </td>
      <td>:</td>
      <td><input type="text" class="form-control" name="keterangan" placeholder="keterangan" autocomplete="off" value="${kas.keterangan}" /></td>
    </tr>
    <tr>
      <td><label for="pemasukan">Pemasukan</label></td>
      <td>:</td>
      <td><input type="text" class="form-control" name="pemasukan" placeholder="pemasukan" autocomplete="off" value="${kas.pemasukan}" /></td>
    </tr>
    <tr>
      <td><label for="pengeluaran">Pengeluaran</label></td>
      <td>:</td>
      <td><input type="text" class="form-control" name="pengeluaran" placeholder="pengeluaran" autocomplete="off" value="${kas.pengeluaran}" /></td>
    </tr>
    <tr>
      <td><button type="submit" class="btn btn-primary">Save</button></td>
    </tr>
    <tr>
    <input type="hidden" name="id" value="${kas.id}" />
      <td><a href="${pageContext.request.contextPath}/home.html">Back to List</a></td>
    </tr>
  </table>
</form>

</html>