import { check } from 'k6';
import http from 'k6/http';

export const options = {
    scenarios: {
        ilk_searyo: {
            executor: 'constant-arrival-rate',
            duration: '30s', // total duration
            preAllocatedVUs: 5000, // to allocate runtime resources

            rate: 1000, // number of constant iterations given `timeUnit`
            timeUnit: '1s',
        },
    },
};


export default function () {
    const headers = { 'Content-Type': 'application/json' };
    const payload = JSON.stringify({
        name: 'Şeker',
        price: 433,
    });
    const getfollow = http.post('http://localhost:9090/product/add-product',payload, { headers });

    check(getfollow, {
        'Post status is 200': (res) => res.status === 200,
        'Post Content-Type header': (res) => res.headers['Content-Type'] === 'application/json',
    });
}

