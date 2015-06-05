/**
 * Created by Iwan on 02.06.2015
 */

$(document).ready(function () {

    hideElements();

    var fileInput = $("#file-upload");
    var uploadButton = $("#upload-button");

    uploadButton.addClass("disabled");

    fileInput.on("change", fileInputOnChange);
    uploadButton.click(uploadButtonOnClick);
});

function loadData(data) {
    showElements();

    $('#article-header').text(data.header);
    $('#article-text').empty();
    $.each(data.text, function (index, value) {
        $('#article-text').append($("<p></p>").text(value));
    });
    $('#table').bootstrapTable('load', data.topWords);
}

function hideElements() {
    $('#text').hide();
    $('#words-top').hide();
}

function showElements() {
    $('#text').show();
    $('#words-top').show();
}
