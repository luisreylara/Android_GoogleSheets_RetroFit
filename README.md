# saveGoogleSheets Aplicación android para el registro y consulta de datos con Google Sheets y API Rest

<img width="200" alt="Screen Shot 2022-09-16 at 20 02 02" src="https://user-images.githubusercontent.com/38077519/190834371-4ab821d8-f63d-4c21-b042-cafc23cd0c97.png">

<img width="200" alt="Screen Shot 2022-09-16 at 20 02 02" src="https://user-images.githubusercontent.com/38077519/190834373-26463b9b-4d11-4828-be75-b16c58ea56cb.png">


<img width="1386" alt="Screen Shot 2022-09-16 at 20 02 02" src="https://user-images.githubusercontent.com/38077519/190834408-044cddbc-1d8f-4959-94de-c95702efd0af.png">


Source:

Consultando e Insertando datos con GOOGLE SHEETS y ANDROID STUDIO [1/2]
https://www.youtube.com/watch?v=ucb8IcEQc10

Consultando e Insertando datos con GOOGLE SHEETS y ANDROID STUDIO [2/2]
https://www.youtube.com/watch?v=_IDOt58suio


Get.gs
```
function getData(spreadsheetId,sheet){
  var rangeName = sheet+'!A:Z';
  var values = Sheets.Spreadsheets.Values.get(spreadsheetId,rangeName).values;
  

  if(!values){
    return {error: "Not data Found"}
  }else{
    var responseJson =[];
    for (var row = 1; row < values.length;row++){
      var item ={};
      for (var column=0; column <26;column++){
        item[values[0][column]] = values[row][column];
      }
      responseJson.push(item);
    }
    return responseJson;
  }
}

function doGet(request) {
  if(request.parameter.spreadsheetId !== undefined && request.parameter.sheet !== undefined){
    return ContentService.createTextOutput(JSON.stringify({personas:getData(request.parameter.spreadsheetId,request.parameter.sheet)})).setMimeType(ContentService.MimeType.JSON);
  }else {
    return ContentService.createTextOutput(JSON.stringify({error: "Parameter not found"}))
  }
  
}

```

Post.gs
```
function doPost(request) {
  var jsonPost = JSON.parse(request.postData.contents);
  var spreadsheetId = jsonPost.spreadsheet_id;
  var sheetName = jsonPost.sheet;
  var rows = jsonPost.rows;

  var sheet = SpreadsheetApp.openById(spreadsheetId).getSheetByName(sheetName);
  for (var i=0;i<jsonPost.rows.length;i++){
    sheet.appendRow(jsonPost.rows[i]);
  } 
  return ContentService.createTextOutput(JSON.stringify({sheet: sheetName,rows:rows}))
}

```
