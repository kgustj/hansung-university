onmessage = function (e) {
    const a = e.data.a;
    const b = e.data.b;

    postMessage({
        add: a + b,
        sub: a - b,
        mul: a * b,
        div: a / b,
    });
};
