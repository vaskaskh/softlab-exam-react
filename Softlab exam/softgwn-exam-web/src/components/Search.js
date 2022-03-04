import React from 'react';
import {Form} from "react-bootstrap";

function Search({value, onchange}) {
    return (
        <div>
            <Form className="mt-2 mb-3">
                <Form.Label>Search</Form.Label>
                <Form.Control type="text" value={value} onChange={onchange} />
            </Form>
        </div>
    );
}

export default Search;