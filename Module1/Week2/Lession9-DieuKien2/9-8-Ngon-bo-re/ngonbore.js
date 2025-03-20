const niceId = document.getElementById("nice")
const fastId = document.getElementById("fast")
const cheapId = document.getElementById("cheap")

function check(id1, id2, id3) {
    if (id1.value === "1") {
        id2.value = "2";
        id3.value = "2";
    } else {
        if (id2.value === "2" && id3.value === "2") {
            id2.value = "1";
        }
    }
}





