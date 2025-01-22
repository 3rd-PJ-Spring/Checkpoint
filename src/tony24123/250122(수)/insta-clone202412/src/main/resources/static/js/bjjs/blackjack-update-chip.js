
async function fetchToChips(userData) {
    await fetch("/api/user/updateChips", {
      method: "PUT",
      headers: { 
        Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
        "Content-Type": "application/json" },
      body: JSON.stringify(userData),
    });  
  }


function fetchToData(){
    const payload = {
        username: currentUserName,
        gameChips: myCoin,
      };
    fetchToChips(payload);
}