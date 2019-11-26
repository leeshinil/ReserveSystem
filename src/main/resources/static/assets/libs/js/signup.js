/**
 *
 */

var id;
var idNow;
var password;
var confirm;
var name;
var phone;
var email;

const signup_btn = document.querySelector("#signup_btn");
const id_btn = document.querySelector("#id_btn");

var id_check;
var id_now_check;
var password_check;
var name_check;
var phone_check;
var email_check;

var signup_agree = document.getElementById('signup_agree');

function goPost() {

    idNow = $("#id").val();
    password = $("#pw").val();
    confirm = $("#confirm").val();
    name = $("#name").val();
    phone = $("#phone").val();
    email = $("#email").val();
    id_now_check = false;
    password_check = false;
    name_check = false;
    phone_check = false;
    email_check = false;
    var signup_agree_check = false;

    const signup_form = document.querySelector("#signup_form");
    if (id_check && idNow == id) {
        id_now_check = true;
    } else {
        alert("학번 중복 체크를 확인해주십시오.");
        return false;
    }
    if (password && (confirm == password)) {
        password_check = true;
    } else {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    if (name != "") {
        name_check = true;
    } else {
        alert("이름을 입력해 주십시오.");
        return false;
    }
    if (phone != "") {
        phone_check = true;
    } else {
        alert("전화번호를 입력해 주십시오.");
        return false;
    }
    if (email != "") {
        email_check = true;
    } else {
        alert("email을 입력해 주십시오.");
        return false;
    }

    if (signup_agree.checked == true) {
        signup_agree_check = true;
    } else {
        alert("회원가입 동의를 체크해주십시오.");
        return false;
    }

    if (id_now_check  && password_check && name_check
        && phone_check && email_check && signup_agree_check) {
        alert("회원가입 성공");
        signup_form.submit();
    } else {
        return false;
    }

}

id_btn.addEventListener('click', function () {
    id = $("#id").val();
    console.log(id);

    var returnData = "";
    if (id != "") {
        idcheck().done(function (data) {
            var result = data.result;
            console.log("result : " + result);
            if (result == "success") {// 중복없음
                alert("사용가능한 학번입니다.");
                id_check = true;
            } else if (result == "fail") {
                alert("이미 가입되어있는 학번입니다.");
            }
        });
    } else {
        alert("학번을 입력하여 주십시오.");
    }
});

function idcheck() {
    id = $("#id").val();
    var obj = new Object();
    obj.id = id;
    var jsonData = JSON.stringify(obj);
    console.log("json : " + jsonData);
    return $.ajax({
        type: 'POST',
        data: jsonData,
        url: "rest/signup_id",
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        error: function (error) {
            console.log(error);
        }
    });
}
