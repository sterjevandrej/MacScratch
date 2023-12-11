function markAsVisited(element) {
    element.parentElement.parentElement.style.backgroundColor = 'grey';
    element.innerHTML += '<b> ПОСЕТЕНО</b>';
}