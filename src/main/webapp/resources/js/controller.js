var refDataTable;


var ajaxUrl = "http://localhost:8080/hwind/rest/product/";
var lang = "ru_ru";


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
            "bProcessing" : false,
            "bServerSide" : true,
            "sAjaxSource" : ajaxUrl,
            "stateSave"   : true,
            "columns": [
                { // id
                    "searchable": false,
                    "orderable" : false,
                },
                {  // name
                    "searchable": true,
                    "orderable": true
                },
                {   // тип
                    "searchable": false,
                    "orderable": false
                },
                {   // приправа
                    "searchable": false,
                    "orderable": false
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

    $('#addRow').click(function () {
        $("#prod-id"   ).val("");
        $("#prod-name").val("");
        $("#prod-type" ).val("");
        $("#prod-spice"  ).val(false);
    });

    $("#detailsForm").submit(function () {
        $('#editRow').modal('hide');
        save();
        return false;
    });



});

function save(){

    var product = {}
    product["id"]          = $("#prod-id"   ).val();
    product["lang"]        = lang;
    product["productName"] = $("#prod-name").val();
    product["productType"] = $("#prod-type" ).val();
    product["spice"]       = $("#prod-spice"  ).val() == "Y";

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : ajaxUrl,
        data : JSON.stringify(product),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            updateTable();
            console.log( "send list.web");
            successNoty('Sended');
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            successNoty('Done');
        }
    });

    return false;
}

<!-- rendering buttons -->

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        var id = row[0];
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(\'' + id + '\');">Edit</a>';
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


<!-- buttons -->
function updateRow(id) {
   $.get(ajaxUrl + id + "/" + lang, function (data) {
       $("#prod-id"   ).val( data.id);
       $("#prod-type" ).val( data.productType);
       $("#prod-name").val( data.productName);
       $("#prod-spice"  ).val( data.spice ? "Y": "N" );

       $('#editRow').modal();
      console.log( "updateRow.ajax");
   });
}

function deleteRow(id) {
  $.ajax({
      url: ajaxUrl + id,
      type: 'DELETE',
      success: function () {
          updateTable();
          console.log( "deleteRow.ajax");
          successNoty('Deleted');
      }
  });
}


function updateTable() {
    refDataTable.rows().invalidate();
    refDataTable.draw();

    console.log( "updated");
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