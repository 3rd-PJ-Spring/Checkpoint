
const $boardContainer = document.querySelector('.board-container');

async function fetchBoards(){
    const response = await fetch('api/posts');
    if(!response.ok) alert('피드 목록을 불러오는데 실패')
    return await response.json();
}

function formatDate(isoDate) {
    const date = new Date(isoDate);
    return date.toLocaleString("ko-KR", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
        hour: "2-digit",
        minute: "2-digit",
    });
}


function createBoardItem({title, content, writer, createdAt}){


    return `
    <div>
        <div class="board-item">
           <div class ="left-container">
           
                <h2>${title}</h2>
                <p>${content}</p>
                <span class ="post-time">
                    ${formatDate(createdAt)}
                </span>
           </div>
            <div class = "right-container">
                <div class="post-username">
                ${writer}
            </div>
            
</div>
            
            
        </div>
        
    </div>`
}

// 피드 렌더링 함수
async function renderBoard(){
    const boardList = await fetchBoards();


    // html 생성
    $boardContainer.innerHTML = boardList.map(board => createBoardItem(board)).join('');
}
function initBoard(){
    renderBoard();
}
export default initBoard;