function controlImageSize(e, img) {
    e.preventDefault();

    let currentWidth = parseInt(img.width);
    let currentHeight = parseInt(img.height);

    if (e.deltaY < 0) {
        currentWidth += 20;
        currentHeight += 15;
    } else {
        currentWidth -= 20;
        currentHeight -= 15;
    }
    img.width = currentWidth;
    img.height = currentHeight;
}
