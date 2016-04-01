var refDataTable;


var ajaxUrl = "http://localhost:8080/hwind/rest/product/";


var failedNote;

var sDeleteBtn = "Delete";
var sEditBtn   = "Edit";



<!-- controller -->
$(document).ready(function() {


    refDataTable = $('#datatable').DataTable(
        {
            "bPaginate": true,
            "bInfo": true,
            "iDisplayStart":0,
            "bProcessing" : true,
            "bServerSide" : true,
            "sAjaxSource" : ajaxUrl,
            "stateSave"   : true,
            "columns": [
                { // id
                    "searchable": true,
                    "orderable" : true,
                },
                {  // name
                    "searchable": true,
                    "orderable": true
                },
                {   // тип
                    "searchable": false,
                    "orderable": true
                },
                {   // приправа
                    "searchable": false,
                    "orderable": true
                },
                {   // deleteBtn
                    "searchable": false,
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderDeleteBtn
                },
                {   // editBtn
                    "searchable": false,
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderEditBtn
                }
            ],
            "initComplete": function (settings, json) {
                $(document).ajaxError(function (event, jqXHR, options, jsExc) {
                    failNoty(event, jqXHR, options, jsExc);
                });
            }
        });



});



<!-- rendering buttons -->

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        var id = row[0];
        return '<a class="btn btn-xs btn-primary" onclick="editRow(\'' + id + '\');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        var id = row[0];
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(\'' + id +'\');">Delete</a>';
    }
    return data;
}


    <!-- Noty -->
function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + errorInfo,
        type: 'error',
        layout: 'bottomRight'
    });
}


function mfailNoty( message) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + message,
        type: 'error',
        layout: 'bottomRight'
    });
}