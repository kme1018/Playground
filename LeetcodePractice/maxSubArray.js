function maxSubArray(arr){
    var currentMax = arr[0];
    var subArrayMax = arr[0];
    var overallMax = arr[0];
    

    for(var i=1;i<arr.length;i++){
        //2 -1 2 3 4 -5
      
        currentMax = Math.max(arr[i], currentMax+arr[i]);
        subArrayMax = Math.max(currentMax, subArrayMax);
        overallMax = Math.max(overallMax, overallMax+arr[i], arr[i]);
    }
    return subArrayMax + " "+ overallMax;
}