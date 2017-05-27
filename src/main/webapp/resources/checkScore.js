function checkScore() {
    var score = document.getElementById("score");
    if (score.value>100||score.value<1){
        var notice =  document.getElementById("score_notice");
        notice.innerHTML="<b style='color: #ff0000;'>请输入0-100之间的数字</b>"
        return false;
    }else {
        var notice =  document.getElementById("score_notice");
        notice.innerHTML=""
    }
    return true;
}

