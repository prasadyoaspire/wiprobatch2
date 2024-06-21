
//Action Creators
export function incrementByOne() {
    return {
        type: 'INCREMENT'
    }
}

export function decrementByOne() {
    return {
        type: 'DECREMENT'
    }
}

export function incrementByTen() {
    return {
        type: 'INCREMENT_BY_VALUE',
        payload : 10
    }
}