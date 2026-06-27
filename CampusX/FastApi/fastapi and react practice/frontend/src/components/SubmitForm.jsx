import { useState } from 'react';

export default function SubmitForm() {
    const [response, setResponse] = useState(null);

    const [formData, setFormData] = useState({
        sepal_length: '',
        sepal_width: '',
        petal_length: '',
        petal_width: ''
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await fetch('http://localhost:8000/iristest', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                sepal_length: parseFloat(formData.sepal_length),
                sepal_width: parseFloat(formData.sepal_width),
                petal_length: parseFloat(formData.petal_length),
                petal_width: parseFloat(formData.petal_width)
            })
        });
        const data = await res.json();
        setResponse(data);
        console.log(data);
    };

    return (
        <div>
            <h2>Iris classification form</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="sepal_length" placeholder="sepal length" value={formData.sepal_length} onChange={handleChange} />
                <input type="text" name="sepal_width" placeholder="sepal width" value={formData.sepal_width} onChange={handleChange} />
                <input type="text" name="petal_length" placeholder="petal length" value={formData.petal_length} onChange={handleChange} />
                <input type="text" name="petal_width" placeholder="petal width" value={formData.petal_width} onChange={handleChange} />
                <button type="submit">Submit</button>
            </form>
            {response && (
                <div>
                    <h3>Response: {JSON.stringify(response.prediction)}</h3>                </div>
            )}
        </div>
    )
}