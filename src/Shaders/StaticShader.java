package Shaders;

import org.lwjgl.util.vector.Matrix4f;

import Entities.Camera;
import Entities.Light;
import Toolbox.Maths;

public class StaticShader extends ShaderProgram
{
	private static final String VERTEX_FILE = "src/Shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "src/Shaders/fragmentShader.txt";
	private int location_transformationMatrix; 
	private int location_projectionMatrix; 
	private int location_viewMatrix; 
	private int location_lightPosition; 
	private int location_lightColor; 

	public StaticShader() 
	{
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() 
	{
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");
	}

	@Override
	protected void getAllUniformLocations() 
	{
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_lightPosition = super.getUniformLocation("lightPosition");
		location_lightColor = super.getUniformLocation("lightColor");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix)
	{
		super.loadMatrix(location_transformationMatrix, matrix);
	}
	
	public void loadLight(Light light)
	{
		super.loadVector(location_lightPosition, light.getPosition());
		super.loadVector(location_lightColor, light.getColor());
	}
	
	public void loadProjectionMatrix(Matrix4f matrix)
	{ 
		super.loadMatrix(location_projectionMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera)
	{ 
		Matrix4f matrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, matrix);
	}

}
