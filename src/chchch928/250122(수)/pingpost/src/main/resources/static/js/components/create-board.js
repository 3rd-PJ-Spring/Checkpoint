const $modal = document.getElementById('CreatePostModal')


async function fetchBoard(){

    const $context = document.getElementById('context-area')

    const BoardData = {
        writer: '임시사용자',
        content: $context.value.trim()
    };

    const response = await fetch ('api/posts', {
        method : 'POST',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(BoardData)
    });

    const data = await response.json();
    console.log(data);

}

function setUpFileUploadEvents(){

    const $submitBtn = document.getElementById('submit-button')

    $submitBtn.addEventListener('click',() => {
        fetchBoard();
    })
}