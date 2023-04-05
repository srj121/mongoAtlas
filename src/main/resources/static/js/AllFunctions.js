function goBack(){
    window.history.back();
}

    function getEmpByNameFunction() {
    let inputElement = document.getElementById("name1");

    link = document.getElementById("name2");
    link.href = "http://localhost:8080/getEmpByName?name="+ inputElement.value;

}
    function getEmpByIdFunction() {
    let inputElement = document.getElementById("name3");

    link = document.getElementById("name4");
    link.href = "http://localhost:8080/getEmpById?id="+ inputElement.value;

}
    function deleteEmpByIdFunction() {
    let inputElement = document.getElementById("id1");

    link = document.getElementById("id2");
    link.href = "http://localhost:8080/deleteEmpById?id="+ inputElement.value;

}
    function addEmpFunction() {
    let idElement = document.getElementById("id");
    let nameElement = document.getElementById("name");
    let addressElement = document.getElementById("address");

    link = document.getElementById("id3");
    link.href = "http://localhost:8080/addEmp?id="
    + idElement.value
    +"&name=" +nameElement.value+
    "&address=" +addressElement.value;
}

