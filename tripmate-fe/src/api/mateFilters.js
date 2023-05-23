export function yyyyMMdd(value) {
    // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
    if (value == "" || value == null) return "";

    // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
    var js_date = new Date(value);

    // 연도, 월, 일 추출
    var year = js_date.getFullYear();
    var month = js_date.getMonth() + 1;
    var day = js_date.getDate();

    // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
    if (month < 10) {
        month = "0" + month;
    }

    if (day < 10) {
        day = "0" + day;
    }

    // 최종 포맷 (ex - '2021/10/08')
    return year.toString().substring(2, 4) + "/" + month + "/" + day;
}

export function period(value, endDate) {
    let start = yyyyMMdd(value);
    let end = yyyyMMdd(endDate);
    if (start == "" && end == "") return "";
    return start + "~" + end;
}

export function age(value) {
    // 들어오는 value 값이 공백이면 그냥 공백으로 돌려줌
    if (value == "" || value == null) return "";

    // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
    var today = new Date();
    var js_date = new Date(value);

    let age = today.getFullYear() - js_date.getFullYear() + 1;

    return parseInt(age / 10) * 10 + " 대";
}
export function gender(value) {
    return value == "M" ? "남성" : value == "F" ? "여성" : "";
}
export function hashtag(value) {
    if (value == "" || value == null) return "\n";
    return "#" + value;
}
export function personCnt(value) {
    if (value == "" || value == null) return "";
    return value + " 명";
}

export function sidoName(value, sidos) {
    if (value == "" || value == null) return "";
    let findSido = sidos.filter((sido) => sido.sidoCode == value);
    if (findSido.length <= 0) return "";
    return findSido[0].sidoName;
}
export function preferenceName(value, preferences) {
    if (value == "" || value == null) return "";
    let findPf = preferences.filter(
        (preference) => preference.preferenceNo == value
    );
    return findPf[0].title;
}
