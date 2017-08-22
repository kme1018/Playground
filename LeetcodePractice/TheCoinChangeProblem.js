function getWays(n, c){
    var cache = {};
    
    var count = function(sum, coins, coinNum){
        cache[sum] = cache[sum] || {};
        if(sum == 0){
           
            return 1;
        }
        else if(sum<0){
            return 0;
        }
        else if (coinNum<=0){
            return 0;
        }
        else if(sum in cache && coinNum in cache[sum]){
            return cache[sum][coinNum];
        }else{
            //console.log("sum = "+sum+" coinNum = "+coinNum);
            
            cache[sum][coinNum] = count(sum, coins, coinNum-1)+count(sum-coins[coinNum-1],coins, coinNum);
            return cache[sum][coinNum];
        }
    }
    
    count(n, c, c.length);
    console.log(cache[n][c.length]);
}

function main() {
    var n_temp = readLine().split(' ');
    var n = parseInt(n_temp[0]);
    var m = parseInt(n_temp[1]);
    c = readLine().split(' ');
    c = c.map(Number);
    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
    var ways = getWays(n, c);
}