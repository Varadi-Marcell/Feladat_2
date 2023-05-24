$(document).ready(function() {
    $("#form").submit(function(e) {
        var a = $("#a").val();
        var b = $("#b").val();

        if (isNaN(a) || isNaN(b)) {
            alert("Hiba: nem számokat adtál meg.");
        } else {
            $.post("/arithmetic", { a: a, b: b }, function(data) {
                window.location.href = "/result?result=" + data;
            });
        }
    });

    $("#geometric-button").click(function(e) {
        var a = $("#a").val();
        var b = $("#b").val();

        $.post("/geometric", { a: a, b: b }, function(data) {
            alert("Mértani átlag: " + data);
        }).fail(function() {
            alert("Hiba: nem számokat adtál meg.");
        });
    });
});
