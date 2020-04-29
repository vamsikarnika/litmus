import React from 'react'
import axios from 'axios'
import { Form, Button } from 'react-bootstrap'
import './SignUpPage.css'

export default class SignUpPage extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            userId: '',
            userName: '',
            emailId: '',
            age: '',
        }
    }
    handleSubmit = (event) => {
        event.preventDefault()
        console.log('submit', event)
        axios.post()
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })
    }

    handleChange = (event) => {
        const {name, value} = event.target
        console.log('change', this.state)
        this.setState({
            [name]: value,
        })
    }

    render(){
        return (
            <div className='formContainer'>
                <Form onSubmit = {this.handleSubmit}>
                    <Form.Group>
                        <Form.Label>User ID</Form.Label>
                        <Form.Control name="userId" type="text" placeholder="Enter User ID" onChange={this.handleChange} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>User Name</Form.Label>
                        <Form.Control name="userName" type="text" placeholder="Enter User Name" onChange={this.handleChange} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Email address</Form.Label>
                        <Form.Control name="emailId" type="email" placeholder="Enter email" onChange={this.handleChange} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Age</Form.Label>
                        <Form.Control name="age" type="number" placeholder="Enter Age" onChange={this.handleChange} />
                    </Form.Group>
                    
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </div>
        )
    }
}