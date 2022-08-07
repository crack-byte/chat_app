import './Login.css'
import {useState} from "react";
import {Link} from "react-router-dom";

function Login() {
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    return (
        <div className="App">
            <div className="outer">
                <div className="inner">
                    <form>
                        <h3>Log in</h3>
                        <div className="form-group">
                            <label>Email</label>
                            <input type="email" className="form-control" name="userName"
                                   placeholder="Enter Email/Username ...."
                                   value={userName}
                                   onChange={(e) => {
                                       setUserName(e.target.value)
                                   }}/>
                        </div>

                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" name="password" placeholder="Enter password"
                                   value={password}
                                   onChange={(e) => {
                                       setPassword(e.target.value)
                                       console.log(password)
                                   }}/>
                        </div>

                        <div className="form-group">
                            <div className="custom-control custom-checkbox">
                                <input type="checkbox" className="custom-control-input" id="customCheck1"/>
                                <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
                            </div>
                        </div>

                        <Link className="btn btn-dark btn-lg btn-block" to="/home">
                            Sign in
                        </Link>
                        <p className="forgot-password text-right">
                            Forgot <a href="#">password?</a>
                        </p>
                    </form>
                </div>
            </div>
        </div>

    );
}

export default Login;