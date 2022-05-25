import { useState, useEffect } from 'react';

function App() {
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        fetch('http://localhost:1234/api/customers')
            .then((resp) => resp.json())
            .then((data) => setCustomers(data.customers));
    }, []);

    const customerListJsx = customers.map((c) => (
        <tr>
            <td>{c.name}</td>
            <td>{c.email}</td>
            <td>{c.phone}</td>
            <td>{c.city}</td>
        </tr>
    ));

    return (
        <>
            <div className='alert alert-primary'>
                <div className='container'>
                    <h1>Customer dashboard</h1>
                </div>
            </div>

            <div className='container'>
                <table className='table table-bordered table-striped'>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>City</th>
                        </tr>
                    </thead>
                    <tbody>{customerListJsx}</tbody>
                </table>
            </div>
        </>
    );
}

export default App;
