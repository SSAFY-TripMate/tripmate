function dateFormat(selectedDate) {
    console.log(selectedDate);
    let startDate = "",
        endDate = "";
    if (selectedDate[0] != null && selectedDate[0] != "") {
        let date = new Date(selectedDate[0]);
        startDate =
            date.getFullYear() +
            "-" +
            (date.getMonth() + 1) +
            "-" +
            date.getDate();
    }
    if (selectedDate[1] != null && selectedDate[1] != "") {
        let date = new Date(selectedDate[1]);
        endDate =
            date.getFullYear() +
            "-" +
            (date.getMonth() + 1) +
            "-" +
            date.getDate();
    }
    console.log(startDate, endDate);
    return [startDate, endDate];
}

export { dateFormat };
