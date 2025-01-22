
async function fetchToSaveHistory(userData) {
    await fetch("/api/history/saveHistory" , {
        method : "POST",
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
    });
}


function fetchToSaveData(){
    const payload = {
        userId : currentUserId,
        userCardSum : playerTotalSum ,
        dealerCardSum : dealerTotalSum ,
        result : result
      };
    fetchToSaveHistory(payload);
}