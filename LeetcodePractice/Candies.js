process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function candies(n, arr) {
    // Complete this function
    var count = [];
    count[0]=1;
    
    for(var i = 0;i<n-1;i++){
        if(arr[i]<arr[i+1]){
           
            count[i+1]=count[i]+1;
        }
        else{
            
            count[i+1]=1;
        }
    }
    var result = 0;
    for(var i = n-1;i>=0;i--){
        var value = i-1;
       
        if(arr[i-1]>arr[i]&& count[i-1]<=count[i]){           
            count[i-1]=count[i]+1;
        }
        result+= count[i];
    }
   
    return result;
}

function main() {
    var n = parseInt(readLine());
    var arr = [];
    for(var arr_i = 0; arr_i < n; arr_i++){
       arr[arr_i] = parseInt(readLine());
    }
    var result = candies(n, arr);
    process.stdout.write("" + result + "\n");

}