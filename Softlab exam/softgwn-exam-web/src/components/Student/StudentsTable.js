import React, {useEffect, useState} from 'react';
import {Button, Form, Table} from "react-bootstrap";
import axios from "axios";
import Search from "../Search";

function StudentsTable(props) {
    const [students, setStudents] = useState([]);
    const [input, setInput] = useState("");

    async function getStudents() {
        const response = await axios.get('students')
        setStudents(response.data)
    }
    useEffect(() => {
        getStudents().catch(console.error)
    },[])

    const filteredStudents = students.filter( student => {
        return (student.firstName.toLowerCase().includes(input.toLowerCase()) + student.lastName.toLowerCase().includes(input.toLowerCase())
            + student.email.toLowerCase().includes(input.toLowerCase())
        );

    })
    return (
        <div>

            <Search value={students.firstName} onchange={e => setInput(e.target.value)}/>

            <Table striped bordered hover className="mt-4">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Personal No</th>
                    <th>Email</th>
                    <th>Birth Date</th>
                </tr>
                </thead>
                <tbody>
                {filteredStudents.map(student => (
                    <tr key={student.id}>
                        <td>{student.id}</td>
                        <td>{student.firstName}</td>
                        <td>{student.lastName}</td>
                        <td>{student.personalNo}</td>
                        <td>{student.email}</td>
                        <td>{student.birthDate}</td>
                        <td><Button>Update</Button></td>
                        <td><Button onClick={() => {
                            axios.delete(`/students/${student.id}`).then(() =>{
                                getStudents().catch(console.error);
                            } )
                        }}>Delete</Button></td>

                    </tr>
                ))}

                </tbody>
            </Table>
        </div>
    );
}

export default StudentsTable;