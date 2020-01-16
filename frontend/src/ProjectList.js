import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ProjectList extends Component {

    constructor(props) {
        super(props);
        this.state = {projects: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/v1/projects')
            .then(response => response.json())
            .then(data => this.setState({projects: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/v1/project/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProjects = [...this.state.projects].filter(i => i.id !== id);
            this.setState({projects: updatedProjects});
        });
    }

    render() {
        const {projects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const projectList = projects.map(project => {
            return <tr key={project.id}>
                <td style={{whiteSpace: 'nowrap'}}>{project.name}</td>
                <td>{project.description}</td>

                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/projects/" + project.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(project.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/projects/new">Add Project</Button>
                    </div>
                    <h3>My CRUD APP</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Name</th>
                            <th width="20%">Description</th>
                            <th width="10%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {projectList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ProjectList;