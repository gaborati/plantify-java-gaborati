import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import {ThemeProvider, useTheme} from "@mui/material/styles";


function SuccessfullyOrdered() {
    const theme = useTheme();

    const customStyles = {
        backgroundImage: 'url("https://img.freepik.com/premium-photo/tropical-palm-leaves-jungle-leaves-seamless-vector-floral-pattern-background_354831-3425.jpg")',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        textAlign: 'center',
        height: '100vh',
        overflow: 'hidden',
    };

    return (
        <ThemeProvider theme={theme}>
            <div
                style={customStyles}
            >
                <Container maxWidth="sm">
                    <Typography variant="h4" gutterBottom
                                style={{fontSize: '45px', fontWeight: 'bold', color: 'whiteSmoke'}}>
                        Successfully Ordered
                    </Typography>
                    <Typography variant="h4" gutterBottom
                                style={{fontSize: '25px', fontWeight: 'bold', color: 'whitesmoke'}}>
                        Thank you! Your order has been successfully placed.
                    </Typography>
                </Container>
            </div>
        </ThemeProvider>
    )
}

export default SuccessfullyOrdered;